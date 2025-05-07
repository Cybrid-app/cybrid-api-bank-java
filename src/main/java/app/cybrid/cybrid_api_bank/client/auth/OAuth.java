package app.cybrid.cybrid_api_bank.client.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-07T18:31:58.001878Z[Etc/UTC]")
public class OAuth implements Authentication {
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public void applyToParams(MultiValueMap<String, String> queryParams, HttpHeaders headerParams, MultiValueMap<String, String> cookieParams) {
        if (accessToken != null) {
            headerParams.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        }
    }
}
