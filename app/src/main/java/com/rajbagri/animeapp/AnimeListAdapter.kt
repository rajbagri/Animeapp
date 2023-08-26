import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajbagri.animeapp.AnimeList
import com.rajbagri.animeapp.OnItemClickListener
import com.rajbagri.animeapp.R
import com.squareup.picasso.Picasso

class AnimeListAdapter(
    context: Context,
    val hero: ArrayList<AnimeList>,
    private val picasso: Picasso,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<AnimeListAdapter.heroViewHolder>() {

    inner class heroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heroImage = itemView.findViewById<ImageView>(R.id.image_view_character_list)
        val heroName: TextView = itemView.findViewById(R.id.text_view_character_list)

        init {
            itemView.setOnClickListener {
                itemClickListener.onItemClick(adapterPosition, hero[adapterPosition].img)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): heroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list, parent, false)
        return heroViewHolder(view)
    }

    override fun onBindViewHolder(holder: heroViewHolder, position: Int) {
        val imageUrl = hero[position].img
        holder.heroName.text = hero[position].charName
        picasso.load(imageUrl).
        into(holder.heroImage)

    }

    override fun getItemCount(): Int {
        return hero.size
    }
}
