package com.spisoft.funkwhale;

/**
 * Created by phoenamandre on 24/04/18.
 */

public interface AsyncResultCallback {
    int RESULT_OK = 0;
    int RESULT_AUTHENTIFICATION_ERROR = -1;

    void onResult(int resultCode, Object data);
}
