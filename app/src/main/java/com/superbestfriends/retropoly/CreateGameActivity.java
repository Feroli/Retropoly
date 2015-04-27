package com.superbestfriends.retropoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.braintreepayments.api.Braintree;
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.TextHttpResponseHandler;

public class CreateGameActivity extends ActionBarActivity {
    private Game game;
    protected String mClientToken;
    //private Braintree mBraintree;
    private int PAYPAL_REQUEST_CODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);
//        game.init();
//        load players;

        //AsyncHttpClient client = new AsyncHttpClient();
        //client.get("https://your-server/client_token", new TextHttpResponseHandler() {
        //    @Override
        //    public void onSuccess(String clientToken) {
        //        mClientToken = clientToken;
        //    }
        //});
//
//        mBraintree = Braintree.getInstance(getApplicationContext(), mClientToken);
//        mBraintree.addListener(new Braintree.PaymentMethodNonceListener() {
//            public void onPaymentMethodNonce(String paymentMethodNonce) {
//                // Communicate the nonce to your server
//            }
//        });
    }

    protected void onPause() {
        super.onPause();

//        mBraintree.lockListeners();
//        mBraintree.removeListener(this);
    }

    protected void onResume() {
        super.onResume();

//        mBraintree.addListener();
//        mBraintree.unlockListeners();
    }
    private class CustomAdapter extends BaseAdapter {

        private Activity context;
        private Player[] player;

        public CustomAdapter(Activity activity, Player[] player) {
            context = activity;
            this.player = player;
        }

        @Override
        public int getCount() {
            return player.length;
        }

        @Override
        public Player getItem(int position) {
            return player[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View rowView = context.getLayoutInflater().inflate(R.layout.layout_list_player, null);
            TextView textView = (TextView) rowView.findViewById(R.id.tv);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.iv);
            textView.setText(getItem(position).getName());
            imageView.setImageResource(getItem(position).getImageId());
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "You Clicked " + getItem(position), Toast.LENGTH_SHORT).show();
                }
            });
            return rowView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else {
//            mBraintree.startPayWithPayPal(this, PAYPAL_REQUEST_CODE);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBraintreeSubmit(View v) {
//        Intent intent = new Intent(this, BraintreePaymentActivity.class);
//        intent.putExtra(BraintreePaymentActivity.EXTRA_CLIENT_TOKEN, mClientToken);
//        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == PAYPAL_REQUEST_CODE) {
//            if (resultCode == BraintreePaymentActivity.RESULT_OK) {
//                String paymentMethodNonce = data.getStringExtra(BraintreePaymentActivity.EXTRA_PAYMENT_METHOD_NONCE);
//                postNonceToServer(paymentMethodNonce);
//            }
//        }
    }

    void postNonceToServer(String nonce) {
//        AsyncHttpClient client = new AsyncHttpClient();
//        RequestParams params = new RequestParams();
//        params.put("nonce", nonce);
//        client.post("https://your-server/payment-method-nonce", params,
//                new AsyncHttpResponseHandler() {
//                    // Your implementation here
//                }
//        );
    }
}

