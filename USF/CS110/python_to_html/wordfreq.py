__author__ = 'alicezhang'

from flask import Flask
from flask import request

app = Flask(__name__)
app.debug = True

@app.route('/')

def form_wordfreq():
    html = ''
    html += '<html>\n'
    html += '<body>\n'
    html += '<form method="POST" action="form_input">\n'
    html += 'text: <input type="text" name="pasted_text" />\n'
    html += '<p>\n'
    html += '<input type="submit" value="submit" />\n'
    html += '</form>\n'
    html += '</body>\n'
    html += '</html>\n'
    return html

@app.route('/form_input', methods=['POST'])
def form_input():
    pasted_text = request.form['pasted_text']
    word_frequency = {}
    alist = pasted_text.split()
    for ch in alist:
        if ch in word_frequency:
            count = word_frequency[ch]
            count = count + 1
            word_frequency[ch] = count
        else:
            word_frequency[ch] = 1

    html = ''
    html += '<html>\n'
    html += '<body>\n'
    html += '<h1>Word and Count</h1>\n'
    html += '<table>\n'
    for ch in word_frequency:
        html += '<tr><td>' + ch + '</td>' + '<td>' + str(word_frequency[ch]) + '</td></tr>\n'
    html += '</table>\n'
    html += '</body>\n'
    html += '</html>\n'
    return html

if __name__ == '__main__':
    app.run()
