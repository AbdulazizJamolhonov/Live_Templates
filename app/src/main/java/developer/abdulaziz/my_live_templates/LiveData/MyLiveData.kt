package developer.abdulaziz.my_live_templates.LiveData

object MyLiveData {
    private val liveData = MutableLiveData<String>()
    fun set(value: String) = liveData.postValue(value)
    fun get(): LiveData<String> = liveData

//    myLiveData.get().observe(viewLifecycleOwner) {
//        binding.tv.text = it
//    }

//    edt.addTextChangedListener {
//        myLiveData.set(it.toString())
//    }
}