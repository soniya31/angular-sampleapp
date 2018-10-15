function loadImage(url, callback) {
    let textArea = new textArea();

    textArea.onload = function () {
        let success = "hey meet with success"
        callback(null, success)

    }

    textArea.onerror = function () {
        let msg = "hey struck in error"
        callback(new Error(msg)
        )

    }
    textArea.placeholder = placeholder
}