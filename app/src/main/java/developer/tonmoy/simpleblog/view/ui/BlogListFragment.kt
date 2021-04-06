
package developer.tonmoy.simpleblog.view.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import developer.tonmoy.simpleblog.R
import developer.tonmoy.simpleblog.data.model.blog.Blog
import developer.tonmoy.simpleblog.databinding.BlogListFragmentBinding
import developer.tonmoy.simpleblog.view.adapter.BlogAdapter
import developer.tonmoy.simpleblog.view.viewmodel.BlogListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class BlogListFragment : Fragment() {

    companion object {
        fun newInstance() = BlogListFragment()
    }

    private  val viewModel: BlogListViewModel by viewModel()
    private lateinit var binding:BlogListFragmentBinding
    private lateinit var  adapter:BlogAdapter
    private val listOfBlog:MutableList<Blog> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.blog_list_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUi()
        setupAdapter()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.listOfBlog().observe(viewLifecycleOwner){
            it?.let { it1 ->
                listOfBlog.clear()
                listOfBlog.addAll(it1)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun setupAdapter() {
        adapter = BlogAdapter(listOfBlog,requireActivity())
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireActivity())
    }

    private fun setupUi() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

}