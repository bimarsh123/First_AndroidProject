package hdu.course.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import hdu.course.myapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
   TextView showCountTextView;
    private FragmentFirstBinding binding;
    @SuppressLint("SetTextI18n")
    private void countMe(View view)
    {
        String countString = showCountTextView.getText().toString();
        // Convert value to a number and increment it
        int count = Integer.parseInt(countString);
        count++;
        // Display the new value in the text view.
        showCountTextView.setText(Integer.toString(count));
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);
        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.randomButton.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment));
        view.findViewById(R.id.toast_button).setOnClickListener(view12 -> Toast.makeText(getActivity(), "Hello Toast", Toast.LENGTH_SHORT).show());
        view.findViewById(R.id.count_button).setOnClickListener(this::countMe);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}