package developer.tonmoy.simpleblog.view.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import developer.tonmoy.simpleblog.R
import developer.tonmoy.simpleblog.view.viewmodel.BlogDetailsViewModel

class BlogDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = BlogDetailsFragment()
    }

    private lateinit var viewModel: BlogDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blog_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlogDetailsViewModel::class.java)

    }

}