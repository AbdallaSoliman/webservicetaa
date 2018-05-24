package iti.t3ala2ma2olk.webservice.security.service;

import java.io.Serializable;

/**
 * @author abdalla
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
