package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Friends.Friend;
import com.example.myapplication.Friends.FriendAdapter;
import com.example.myapplication.Network.Api;
import com.example.myapplication.Network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoomsFragment extends Fragment{

    RecyclerView mRecyclerView;
    FriendAdapter mfriendAdapter;
    TextView emptyList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rooms, container, false);
        LoadDetails(view);
        return view;
    }


    private ArrayList<Friend> getFriendList(){
        ArrayList<Friend> friends = new ArrayList<>();

        Friend friend = new Friend();
        friend.setNickname("INEXY");
        friend.setStatus("here we go");
        friend.setImg(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ic_profile));
        friends.add(friend);

        friend = new Friend();
        friend.setNickname("NEXY");
        friend.setStatus("kek");
        friend.setImg(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ic_profile));
        friends.add(friend);

        friend = new Friend();
        friend.setNickname("Admin");
        friend.setStatus("вы");
        friend.setImg(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ic_profile));
        friends.add(friend);

        friend = new Friend();
        friend.setNickname("Guest");
        friend.setStatus("undefined");
        friend.setImg(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ic_profile));
        friends.add(friend);

        friend = new Friend();
        friend.setNickname("omg12_2");
        friend.setStatus("you are like me");
        friend.setImg(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ic_profile));
        friends.add(friend);

        friend = new Friend();
        friend.setNickname("killstation");
        friend.setStatus("wrong suppose");
        friend.setImg(BitmapFactory.decodeResource(getContext().getResources(),R.drawable.ic_profile));
        friends.add(friend);

        friend = new Friend();
        friend.setNickname("dracula1723");
        friend.setStatus("is it true?");
        friend.setImg(BitmapFactory.decodeResource(getContext().getResources(),R.drawable.ic_profile));
        friends.add(friend);

        return friends;
    }

    private void LoadDetails(View view){
        ApiService apiService = new ApiService();
        Api api = apiService.getApiService().create(Api.class);
        Call<List<Friend>> call = api.getFriends();

        call.enqueue(new Callback<List<Friend>>() {
            @Override
            public void onResponse(Call<List<Friend>> call, Response<List<Friend>> response) {
                List<Friend> friends = null;
                friends=response.body();

                for (Friend friend : friends) {
                    Bitmap icon = getBitmapFromVectorDrawable(getContext(),R.drawable.ic_profile);
                    friend.setImg(icon);
                }
                DisplayUserList(friends, view);
            }

            @Override
            public void onFailure(Call<List<Friend>> call, Throwable t) {

            }
        });
        return;
    }

    private void DisplayUserList(List<Friend> friends, View view){
        ArrayList<Friend> friendList = new ArrayList<Friend>();
        friendList.addAll(friends);

        TextView mTextView = (TextView) view.findViewById(R.id.no_rooms);
        emptyList= view.findViewById(R.id.empty_recycler_view);
        mRecyclerView= view.findViewById(R.id.recyclerview_online_friends);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mfriendAdapter = new FriendAdapter(this.getContext(), friendList);
        mRecyclerView.setAdapter(mfriendAdapter);

        if (!friendList.isEmpty()){
            emptyList.setVisibility(View.GONE);
        }
    }


    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

}

