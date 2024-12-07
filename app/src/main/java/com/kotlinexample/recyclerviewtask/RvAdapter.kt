import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlinexample.task1.Movie
import com.kotlinexample.task1.R
import com.kotlinexample.task1.databinding.RvItemBinding

class RvAdapter : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    private val items = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size



    class ViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movie) {
            binding.textViewTitle.text = item.title
            binding.textViewDescription.text = item.description
            binding.textViewRating.text = "Rating: ${item.rating}/5"

            Glide.with(binding.root.context)
                .load(item.imageUrl)
                .placeholder(R.drawable.baseline_local_movies_24) // Replace with your placeholder image
                .into(binding.imageView)
        }
    }



    fun addItems(items: List<Movie>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }


}
