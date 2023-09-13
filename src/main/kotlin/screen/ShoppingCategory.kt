package screen

class ShoppingCategory {

    fun showCategories() {
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

            if(categories.contains(selectedCategory)){
                // TODO 2. show category
            }else{
                showErrorMessage(selectedCategory)
            }

        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : not existed please retry")
        showCategories()
    }

}