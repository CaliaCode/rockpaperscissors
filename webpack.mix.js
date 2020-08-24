let mix = require('laravel-mix');

// Typescript
mix.ts('src/main/frontend/ts/app.ts', 'src/main/resources/public/js')

// SASS
mix.sass('src/main/frontend/scss/app.scss', 'src/main/resources/public/css');

mix.options({
    processCssUrls: false
})
