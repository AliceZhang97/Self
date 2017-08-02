__author__ = 'alicezhang'

from flask import Flask
from flask import request

import tmdbsimple as tmdb
tmdb.API_KEY = 'e6f17257b2b4e57aee15be6d285698fa'

app = Flask(__name__)
app.debug = True

@app.route('/')

def examples():
    html = ''
    html += '<html>\n'
    html += '<body>\n'
    html += '<form method="POST" action="form_input">\n'
    html += 'Search Movie: <input type="text" name="search_movie" />\n'
    html += '<p>\n'
    html += '<input type="submit" value="submit" />\n'
    html += '</form>\n'
    html += '</body>\n'
    html += '</html>\n'
    return html

@app.route('/form_input', methods=['POST'])
def form_input():
    movie_name = request.form['search_movie']
    search = tmdb.Search()
    response = search.movie(query= movie_name)

    html = ''
    html += '<html>\n'
    html += '<body>\n'
    html += '<h3>Search Movie</h3>\n'
    html += '<table>\n'
    for s in search.results:
        movie_name = s['title']
        popularity = str(s['popularity'])
        release_date = str(s['release_date'])
        id = str(s['id'])
        html += '<tr><td>' + movie_name + '</td><td>' + popularity + '</td><td>' + release_date +'</td><td>' + id + '</td></tr>\n'
    html += '</table>\n'
    html += '</body>\n'
    html += '</html>\n'
    return html

if __name__ == '__main__':
    app.run()
