
package com.bharath.springboot.errormessage.api;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Errors {

    private String message;
    private String domain;
    private String reason;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
