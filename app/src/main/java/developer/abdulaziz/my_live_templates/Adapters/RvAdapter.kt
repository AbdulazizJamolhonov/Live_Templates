package developer.abdulaziz.my_live_templates.Adapters

class RvAdapter(
    private val list: ArrayList<User>
) :
    RecyclerView.Adapter<MyUnivrsalAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemUniversalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: User, position: Int) {}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemUniversalBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(hol: ViewHolder, pos: Int) = hol.onBind(list[pos], pos)
    override fun getItemCount(): Int = list.size
}