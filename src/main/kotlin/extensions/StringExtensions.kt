package extensions

fun String?.getNotEmptyString(): String{
    var input = this
    while(input.isNullOrBlank()){
        println("please re-input the value")
        input = readLine()
    }
    return input.trim()
}

fun String?.getNotEmptyInt():Int{
    var input = this?.trim()
    while(input.isNullOrEmpty()||input.toIntOrNull() == null){
        println("please re-input the value")
        input = readLine()
    }
    return input.toInt()
}