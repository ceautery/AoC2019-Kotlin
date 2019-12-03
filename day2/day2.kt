val text = java.io.File("input.txt").readText()
val initial = text.trim().split(',').map { it.toInt() }

fun run(noun: Int, verb: Int): Int {
  val program = initial.toMutableList()
  program[1] = noun
  program[2] = verb

  for(i in 0..(program.size - 1) step 4) {
    val code = program[i]
    if (code == 99) break

    val reg1 = program[program[i + 1]]
    val reg2 = program[program[i + 2]]
    program[program[i + 3]] = if (code == 1) reg1 + reg2 else reg1 * reg2
  }

  return program[0]
}

fun part1(): Int {
  return run(12, 2)
}

fun part2(): Int {
  for (i in 0..99) {
    for (j in 0..99) {
      if (run(i, j) == 19690720) return i * 100 + j
    }
  }

  return 0
}

fun main() {
  val answer1 = part1()
  println("Part1: $answer1")

  val answer2 = part2()
  println("Part2: $answer2")
}

