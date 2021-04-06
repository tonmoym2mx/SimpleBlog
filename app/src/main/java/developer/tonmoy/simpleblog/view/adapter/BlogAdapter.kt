package developer.tonmoy.simpleblog.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import developer.tonmoy.simpleblog.R
import developer.tonmoy.simpleblog.data.model.blog.Blog
import developer.tonmoy.simpleblog.databinding.RowBlogBinding

class BlogAdapter(private val listOfBlog: List<Blog>,private val context: Context): RecyclerView.Adapter<BlogHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:RowBlogBinding  = DataBindingUtil.inflate(layoutInflater, R.layout.row_blog,parent,false)
        return BlogHolder(binding)
    }

    override fun onBindViewHolder(holder: BlogHolder, position: Int) {
        val blog = listOfBlog[position]
        holder.bind(blog,context)
    }

    override fun getItemCount() = listOfBlog.size
}
class BlogHolder(private val binding: RowBlogBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(blog:Blog,context: Context){
        binding.title.text = blog.title?:""
        binding.details.text = blog.description?:""

        Glide.with(context)
            .load(blog.coverPhoto)
            .placeholder(R.drawable.placeholder)
            .into(binding.imageView)
    }
}