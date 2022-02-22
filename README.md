# file-uploader

A Clojure library designed to test file encoding

## Usage

Start Server

```bash
$ lein run
```

Test server
```bash
$ curl --request GET 'localhost:5100/'
$ curl -X POST -H "content-type: multipart/form-data" localhost:5100/upload -F "file=@docs/test.txt"
"UTF-8"
$ curl -X POST -H "content-type: multipart/form-data" localhost:5100/upload -F "file=@docs/test.png"
"clojure.lang.ExceptionInfo in Interceptor :file-uploader.views.upload/upload - encoding not detected"
```
