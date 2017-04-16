/*
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 *
 * I compute all possible solutions and then subtract the invalid ones.
 *
 * - All possible solutions are just 'N choose 2'.
 * - Invalid solutions are those were we take two nodes from the same subgraph.
 *      i.e all 'K choose 2' for every subgraph population K.
 *
 * Also be careful to use BigInteger for computing the solution.
 */

readInput()
print solution()

def readInput() {
    def s = new Scanner(System.in)
    N = s.nextInt()
    P = s.nextInt()
    s.nextLine()

    g = [:].withDefault { key -> [] }

    P.times {
        def A = s.nextInt()
        def B = s.nextInt()
        if (s.hasNextLine()) s.nextLine()

        g[A] << B
        g[B] << A
    }
}

def solution() {
    if (N <= 1) return 0
    if (P < 1) return choose2(N)

    List populations = getSubgraphsPopulation()
    def solution = choose2(N)
    populations.each { solution -= choose2(it) }

    return solution
}

private def choose2(BigInteger n) {
    n * (n - 1) / 2
}

def getSubgraphsPopulation() {
    def populations = []
    def visited = [:].withDefault { key -> false }
    N.times { populations << populationOf(it, visited) }
    return populations.grep { it > 0 }
}

private def populationOf(int n, Map visited) {
    if (visited[n]) return 0
    visited[n] = true
    def population = 1
    g[n].each { population += populationOf(it, visited) }
    return population
}
