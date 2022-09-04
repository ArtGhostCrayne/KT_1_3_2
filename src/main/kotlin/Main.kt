fun main(args: Array<String>) {

    val payType: String = "Mastercard" //VKpay, Mastercard, Maestro, Mir, Visa
    val sumPerMonth = 70000
    val amount = 300

    println("Перевод на $amount руб. комиссия составит ${calcFee(sumPerMonth = sumPerMonth, amount = amount)} коп.")

}

fun calcFee(payType: String = "VKpay", sumPerMonth: Int, amount: Int): Int {

    return when (payType) {
        "VKpay" -> 0
        "Mastercard", "Maestro" -> if (sumPerMonth < 75000) {
            ((amount * 100) / 100 * 0.6).toInt()
        } else {
            0
        }

        "Mir", "Visa" -> ((amount * 100) / 100 * 0.75).toInt()
        else -> 0
    }
}