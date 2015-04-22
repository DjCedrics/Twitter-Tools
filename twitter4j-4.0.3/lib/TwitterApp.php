<?php
class TwitterApp {
    /**
     * This variable holds the tmhOAuth object used throughout the class
     *
     * @var tmhOAuth An object of the tmhOAuth class
     */
    public $tmhOAuth;
 
    /**
     * User's Twitter account data
     *
     * @var array Information on the current authenticated user
     */
    public $userdata;
 
    /**
     * Authentication state
     *
     * Values:
     *  - 0: not authed
     *  - 1: Request token obtained
     *  - 2: Access token obtained (authed)
     *
     * @var int The current state of authentication
     */
    protected $state;
 
    /**
     * Initialize a new TwitterApp object
     *
     * @param tmhOAuth $tmhOAuth A tmhOAuth object with consumer key and secret
     */
    public function  __construct(tmhOAuth $tmhOAuth) {
         
        // save the tmhOAuth object
        $this->tmhOAuth = $tmhOAuth;
    }
}