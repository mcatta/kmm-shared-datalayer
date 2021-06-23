package dev.marcocattaneo.kmmapp.android.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import dagger.hilt.android.AndroidEntryPoint
import dev.marcocattaneo.kmmapp.android.R
import dev.marcocattaneo.kmmapp.data.models.Repository

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.repoList) }

    private val adapter = RepoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        mainViewModel.dataLiveData.observe(this) { adapter.submitList(it) }
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.fetch()
    }

    inner class RepoAdapter : ListAdapter<Repository, RepoAdapter.RepositoryViewHolder>(
        object : DiffUtil.ItemCallback<Repository>() {
            override fun areItemsTheSame(oldItem: Repository, newItem: Repository) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Repository, newItem: Repository) = oldItem == newItem
        }
    ) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
            return RepositoryViewHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false))
        }

        override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) = holder.bind(getItem(position))

        inner class RepositoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

            private val textView: TextView = itemView.findViewById(android.R.id.text1)

            fun bind(repository: Repository) {
                textView.text = repository.name
            }

        }
    }
}
