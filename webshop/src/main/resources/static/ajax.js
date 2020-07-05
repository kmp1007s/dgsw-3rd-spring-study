const ajax = {
    server: "http://localhost:8080",
    dataType: "json",
    contentType: "application/json",

    get: function (endpoint, success, error) {
        $.ajax({
            url: this.server + endpoint,
            method: "GET",
            dataType: this.dataType,
            success,
            error
        });
    },
    post: function (endpoint, data, success, error) {
        $.ajax({
            url: this.server + endpoint,
            method: "POST",
            contentType: this.contentType,
            data: JSON.stringify(data),
            success,
            error,
        });
    },
    put: function (endpoint, data, success, error) {
        $.ajax({
            url: this.server + endpoint,
            method: "PUT",
            contentType: this.contentType,
            data: JSON.stringify(data),
            success,
            error,
        });
    },
    delete: function (endpoint, success, error) {
        $.ajax({
            url: this.server + endpoint,
            method: "DELETE",
            dataType: this.dataType,
            success,
            error,
        });
    },
};