__author__ = 'alicezhang'

from flask import Flask
from flask import request

app = Flask(__name__)
app.debug = True

@app.route('/')

def form_kilometers():
    html = ''
    html += '<html>\n'
    html += '<body>\n'
    html += '<form method="POST" action="form_input">\n'
    html += 'Kilometers: <input type="text" name="kilometers" />\n'
    html += '<p>\n'
    html += '<input type="submit" value="submit" />\n'
    html += '</form>\n'
    html += '</body>\n'
    html += '</html>\n'
    return html

@app.route('/form_input', methods=['POST'])
def form_input():
    kilometers = request.form['kilometers']
    miles = int(kilometers) * 0.621371
    html = ''
    html += '<html>\n'
    html += '<body>\n'
    html += 'You entered ' + kilometers + 'kilometers. The equivalent in miles is ' + str(miles) + '\n'
    html += '</body>\n'
    html += '</html>\n'
    return html

if __name__ == '__main__':
    app.run()
