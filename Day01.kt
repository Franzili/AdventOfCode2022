import java.io.File
import java.util.*

fun countCalories(fileName: String): Int {
    val sc = Scanner(File(fileName))
    var mostCalories = 0
    var secMostCalories = 0
    var thirdMostCalories = 0
    var sumCaloriesElv = 0
    while (sc.hasNextLine()) {
        val line = sc.nextLine()
        if (line.isEmpty()) {
            when {
                sumCaloriesElv > mostCalories -> {
                    thirdMostCalories = secMostCalories
                    secMostCalories = mostCalories
                    mostCalories = sumCaloriesElv
                }
                sumCaloriesElv > secMostCalories -> {
                    thirdMostCalories = secMostCalories
                    secMostCalories = sumCaloriesElv
                }
                sumCaloriesElv > thirdMostCalories -> thirdMostCalories = sumCaloriesElv
            }
            sumCaloriesElv = 0
            continue
        }
        sumCaloriesElv += line.toInt()
    }
    println(mostCalories)
    println(secMostCalories)
    println(thirdMostCalories)
    return mostCalories + secMostCalories + thirdMostCalories
}

fun main() {
    println(countCalories("/Users/franziskaniemeyer/MegaSync/Programming/Kotlin/AdventOfCode2022/Day01-input.txt"))
}
