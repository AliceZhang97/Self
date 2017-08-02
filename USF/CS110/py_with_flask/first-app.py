__author__ = 'alicezhang'

from flask import Flask
from flask import request

app = Flask(__name__)
app.debug = True

@app.route('/')

def form_example():
    html = ''
    html += '<html>\n'
    html += '<body>\n'
    html += '<form method="POST" action="form_input">\n'
    html += 'Fahrenheit: <input type="text" name="fahrenheit" />\n'
    html += '<p>\n'
    html += '<input type="submit" value="submit" />\n'
    html += '</form>\n'
    html += '</body>\n'
    html += '</html>\n'
    return html

@app.route('/form_input', methods=['POST'])
def form_input():
    fahrenheit = request.form['fahrenheit']
    celsius = int(fahrenheit) - 32
    celsius = celsius * (5/9)
    html = ''
    html += '<html>\n'
    html += '<body>\n'
    html += 'The equivalent Celsius is: ' + str(celsius) + '\n'
    html += '</body>\n'
    html += '</html>\n'
    return html

if __name__ == '__main__':
    app.run()
