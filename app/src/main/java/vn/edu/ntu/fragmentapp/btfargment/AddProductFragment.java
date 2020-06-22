package vn.edu.ntu.fragmentapp.btfargment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.telephony.IccOpenLogicalChannelResponse;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.ntu.fragmentapp.R;
import vn.edu.ntu.fragmentapp.controller.IController;
import vn.edu.ntu.fragmentapp.model.Product;

public class AddProductFragment extends Fragment {

    EditText edtName, edtPrice, edtDesc;
    Button btnAdd;
    NavController navController;

    public AddProductFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_product,container,false);
        addViews(view);
        addActions();
        navController = NavHostFragment.findNavController(AddProductFragment.this);
        ((MainActivity)getActivity()).navcontroller = navController;
        return view;
    }

    private void addViews(View view){
        edtName = view.findViewById(R.id.edtName);
        edtPrice = view.findViewById(R.id.edtPrice);
        edtDesc = view.findViewById(R.id.edtDesc);
        btnAdd = view.findViewById(R.id.btnAdd);
    }

    private void addActions(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p = new Product();
                p.setName(edtName.getText().toString());
                p.setPrice(Integer.parseInt(edtPrice.getText().toString()));
                p.setDesc(edtDesc.getText().toString());

                IController controller = ((MainActivity)getActivity()).controller;
                controller.addProduct(p);

                edtName.setText("");
                edtPrice.setText("");
                edtDesc.setText("");

                Toast.makeText( AddProductFragment.this.getActivity(),"Đã thêm mặt hàng",Toast.LENGTH_SHORT).show();

            }
        });

    }

}
