class ShoppingHome {

    fun start(){

        showWelcomeMessage()

        showCategories()
    }
    private fun showWelcomeMessage() {
        println("hello, welcome to my application")
        println("if you want to continue, please input your name")
        val name = readLine()
        println(
            """
            hello $name
            pleaze input your category in wish
            ***==========================
            """.trimIndent()
        )
    }
    private fun showCategories() {
        val categories = arrayOf("fassion", "electonics", "veterian")
        for (category in categories) {
            println(category)
        }

        println("=> if you want to go pocket input #")

        var selectedCategory = readLine()
        while (selectedCategory.isNullOrBlank()) {
            println("please input value")
            selectedCategory = readLine()
        }

        if (selectedCategory == "#") {
            // TODO 1. move to pocket
        } else {
            // TODO 2. show category
            // TODO 3. if not in value
        }
    }



}