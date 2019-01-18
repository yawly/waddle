

var updatePost = (id, properties) => {

    fetch('http://localhost:8080/post/'+id, {
        method: "POST",
        body: properties
    }).
    then((response) => {
        return response.json();
    }).
    then((data) => {

        return data;
    });

};