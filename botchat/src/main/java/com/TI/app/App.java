package com.TI.app;

// Construct an instance of the Mixer API such that we can query certain
// endpoints for data.
MixerAPI mixer = new MixerAPI();

// Invoke the `UsersService.class` in order to access the methods within
// that service.  Then, assign a callback using Guava's FutureCallback
// class so we can act on the response.
Futures.addCallback(mixer.use(UsersService.class).search("tta"), new ResponseHandler<UserSearchResponse>() {
    // Set up a handler for the response
    @Override public void onSuccess(UserSearchResponse response) {
        for (MixerUser user : response) {
            System.out.println(user.username);
        }
    }
});
