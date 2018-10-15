var path = require('path');
var extractTextPlugin = require('extract-text-webpack-plugin');
var extractPlugin=new extractTextPlugin({
    filename: 'bundle.css'
});

module.exports = {
    entry: './src/js/main.js',
    output: {
        path: path.resolve('__dirname', 'dist'),
        filename: 'bundle.js',
        
        publicPath: '/dist'


    },
    module: {
        rules: [

            {
                test: '/\.js$/',
                use: [

                    {
                        loader: 'babel-loader',
                        options: {
                            presets: 'es2015'
                        }

                    }

                ]
            },
            {
                test: '/\.scss$/',
                use: extractPlugin.extract({
                    use:['css-loader,sass-loader']
                })
            }
        ]

    }
}