val weights = java.io.File("input.txt").readLines().map { it.toInt() }

fun fuel(n: Int): Int {
  return maxOf(n / 3 - 2, 0)
}

fun accum(n: Int): Int {
  val f = fuel(n)
  return if (f > 0) f + accum(f) else f
}

fun part1(): Int {
  return weights.map(::fuel).sum()
}

fun part2(): Int {
  return weights.map(::accum).sum()
}

fun main() {
  val answer1 = part1()
  println("Part 1: $answer1")

  val answer2 = part2()
  println("Part 2: $answer2")
}

