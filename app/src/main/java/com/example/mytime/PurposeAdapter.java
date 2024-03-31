//package com.example.mytime;
//
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.EventListener;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreException;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import java.util.Objects;
//
//public class PurposeAdapter extends RecyclerView.Adapter<PurposeAdapter.ViewHolder> {
//
//    @NonNull
//    @Override
//    public PurposeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_purpose_item, parent, false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PurposeAdapter.ViewHolder holder, int position) {
//        holder.Name_purp;
//    }
//
//    @Override
//    public int getItemCount() {
//        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        FirebaseFirestore.getInstance().collection("users").document(currentuser)
//                .collection("users_data").whereEqualTo("field", "value" )
//                .addSnapshotListener(
//                        new EventListener<QuerySnapshot>() {
//                            @Override
//                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException e) {
//                                // Обработка ошибок
//                                if (e != null) {
//                                    return;
//                                }
//                                return value.size();
//                            }
//                        }
//                );
//
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView Name_purp;
//        public ProgressBar purpesBar;
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            Name_purp = itemView.findViewById(R.id.namePurp);
//            purpesBar = itemView.findViewById(R.id.purposefrr);
//            String currentuser = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
//            FirebaseFirestore.getInstance().collection( "users" ).document(currentuser)
//                    .collection("users_data")
//                    .whereEqualTo("field", "value" )
//                    .addSnapshotListener(
//                            new EventListener<QuerySnapshot>()
//                            {
//                                @Override
//                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException e )
//                                {
//                                    // Обработка ошибок
//                                    if ( e != null )
//                                    {
//                                        return 0;
//                                    }
//
//                                    Log.e( "MESSAGE", "Количество документов " + value.size() );
//
//
//                                    return 0;
//                                }
//                            }
//                    );
//        }
//    }
//
//
//}
