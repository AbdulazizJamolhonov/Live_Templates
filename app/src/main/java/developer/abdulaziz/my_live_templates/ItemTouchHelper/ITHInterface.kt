package developer.abdulaziz.my_live_templates.ItemTouchHelper

interface ITHInterface {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDismiss(position: Int)
}