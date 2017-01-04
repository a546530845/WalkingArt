package com.zxgzeroapp.workingart.http.download;

public interface DownloadProgressListener {
    void update(long bytesRead, long contentLength, boolean done);
}