package com.example.vivianbabiryekulumba.townhall.main_fragments;


import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.vivianbabiryekulumba.townhall.R;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterToVoteOnlineFrag extends Fragment {

    private static final String TAG = "RegisterOnlineFrag";
    WebView webView;

    public RegisterToVoteOnlineFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_to_vote_online, container, false);

        webView = view.findViewById(R.id.dmv_web_registration);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://voterreg.dmv.ny.gov/MotorVoter/");
        webView.setWebViewClient(new TolerantWebViewClient());
        return view;
    }


    private class TolerantWebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }
}
