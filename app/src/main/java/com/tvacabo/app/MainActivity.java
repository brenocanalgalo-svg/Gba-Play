package com.tvacabo.app;

import android.app.Activity;
import android.os.Bundle;
import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoRuntimeSettings;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GeckoView view = findViewById(R.id.geckoview);
        GeckoSession session = new GeckoSession();
        
        GeckoRuntimeSettings.Builder builder = new GeckoRuntimeSettings.Builder()
            .setTrustedRecursiveResolverMode(3)
            .setTrustedRecursiveResolverUri("https://mozilla.cloudflare-dns.com/dns-query");
            
        GeckoRuntime runtime = GeckoRuntime.create(this, builder.build());
        session.open(runtime);
        view.setSession(session);
        session.loadUri("https://harmonious-parfait-a4975b.netlify.app/");
    }
}
