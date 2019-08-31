package models

data class Todo(var id: Int = 0,
                var title: String = "",
                var completed: Boolean = false) {
}
