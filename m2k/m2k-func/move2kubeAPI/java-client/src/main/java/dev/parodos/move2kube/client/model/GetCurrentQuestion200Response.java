/*
 * Move2Kube API
 * This is a documentation of the Move2Kube REST API. All API calls expect the `Authorization: Bearer <access-token>` HTTP header unless specified otherwise. The access token can be obtained in the same way as OAuth 2.0 using the token endpoint in the admin section. 
 *
 * The version of the OpenAPI document: v1.0.0
 * Contact: move2kube-dev@googlegroups.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package dev.parodos.move2kube.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * GetCurrentQuestion200Response
 */
@JsonPropertyOrder({
  GetCurrentQuestion200Response.JSON_PROPERTY_QUESTION
})
@JsonTypeName("get_current_question_200_response")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-17T12:21:13.081862Z[Etc/UTC]")
public class GetCurrentQuestion200Response {
  public static final String JSON_PROPERTY_QUESTION = "question";
  private String question;

  public GetCurrentQuestion200Response() {
  }

  public GetCurrentQuestion200Response question(String question) {
    
    this.question = question;
    return this;
  }

   /**
   * A JSON encoded string of the question object.
   * @return question
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_QUESTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getQuestion() {
    return question;
  }


  @JsonProperty(JSON_PROPERTY_QUESTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQuestion(String question) {
    this.question = question;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCurrentQuestion200Response getCurrentQuestion200Response = (GetCurrentQuestion200Response) o;
    return Objects.equals(this.question, getCurrentQuestion200Response.question);
  }

  @Override
  public int hashCode() {
    return Objects.hash(question);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCurrentQuestion200Response {\n");
    sb.append("    question: ").append(toIndentedString(question)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `question` to the URL query string
    if (getQuestion() != null) {
      try {
        joiner.add(String.format("%squestion%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getQuestion()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}
