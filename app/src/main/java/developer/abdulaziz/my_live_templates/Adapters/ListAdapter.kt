package developer.abdulaziz.my_live_templates.Adapters

class ListAdapter : ListAdapter<User, MyListAdapter.VH>(MyDifUtils()) {
    inner class VH(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: User) {}
    }

    class MyDifUtils : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
        override fun areContentsTheSame(old: User, new: User): Boolean = old.equals(new)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(hold: VH, pos: Int) = hold.onBind(getItem(pos))
}