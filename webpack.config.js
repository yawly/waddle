const path = require('path');

module.exports = {
    mode: 'development',

    entry: './src/main/js/posts/index.jsx',
    output: {
        filename: 'posts.js',
        path: path.resolve(__dirname, './src/main/resources/static/')
    },

    module: {
        rules: [
            {
                test: /\.jsx?$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            }
        ]
    }
};