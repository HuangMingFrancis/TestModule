package com.example.francis.amoudle;

import com.example.francis.commonmodule.User;
import com.example.francis.commonmodule.route.FullUri;
import com.example.francis.commonmodule.route.IntentExtrasParam;
import com.example.francis.commonmodule.route.UriParam;

/**
 * Created by Francis on 2018/3/14.
 */

public interface RouterService {
    @FullUri("router://com.example.francis.bmodule")
    void startUserActivity(@UriParam("cityName")
                                   String cityName, @IntentExtrasParam("user") User user);
}
