package com.example.serhat.databindingex.Adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.serhat.databindingex.BR;
import com.example.serhat.databindingex.R;
import com.example.serhat.databindingex.ViewModel.ContactVM;

import java.lang.ref.WeakReference;

/**
 * Created by Serhat on 01/12/15.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.BindingHolder> {
    private ObservableArrayList<ContactVM> movies;

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public ContactAdapter(ObservableArrayList<ContactVM> movies) {
        this.movies = movies;
        this.movies.addOnListChangedCallback(new WeakReferenceOnListChangedCallback(this));
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        BindingHolder holder = new BindingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final ContactVM aMovie = movies.get(position);
        holder.getBinding().setVariable(BR.contactItem, aMovie);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    private static class WeakReferenceOnListChangedCallback extends ObservableList.OnListChangedCallback {

        private final WeakReference<ContactAdapter> adapterReference;

        public WeakReferenceOnListChangedCallback(ContactAdapter bindingRecyclerViewAdapter) {
            this.adapterReference = new WeakReference<>(bindingRecyclerViewAdapter);
        }

        @Override
        public void onChanged(ObservableList sender) {
            RecyclerView.Adapter adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
            RecyclerView.Adapter adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyItemRangeChanged(positionStart, itemCount);
            }
        }

        @Override
        public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
            RecyclerView.Adapter adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyItemRangeInserted(positionStart, itemCount);
            }
        }

        @Override
        public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
            RecyclerView.Adapter adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyItemMoved(fromPosition, toPosition);
            }
        }

        @Override
        public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
            RecyclerView.Adapter adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyItemRangeRemoved(positionStart, itemCount);
            }
        }
    }

}

