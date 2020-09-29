package controller;

import java.io.IOException;
import java.net.URISyntaxException;

import http.request.HttpRequest;
import http.response.HttpResponse;
import utils.FileIoUtils;

public class StaticController extends AbstractController {

    @Override
    void doGet(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException, URISyntaxException {
        byte[] body = FileIoUtils.loadFileFromClasspath("./static" + httpRequest.getUrl());
        httpResponse.response200Header(httpRequest.getHttpRequestHeaderByName("Accept").split(",")[0], body.length);
        httpResponse.responseBody(body);
    }

    @Override
    void doPost(HttpRequest httpRequest, HttpResponse httpResponse) {}
}
