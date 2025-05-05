const express = require('express');
const app = express();
const port = 3000;

// For HTML Rendering
const fs = require('fs');
const ejs = require("ejs");
const router = express.Router();
// End

app.get('/', (req, res) => {
  res.send('Hello World!');
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`);
});

// For HTML Rendering
router.post('/api/example', async function (req, res) {
  const {name, items} = req.body.params;
   const destFolder = 'reports';
  generateHtmlFromEjs(__dirname, destFolder, 'report,html', '/templates/report.ejs', information);
  res.send('complete');
});

const generateHtmlFromEjs = (basePath, destFolder, name, template, information) => {
  fs.readFile(path.join(basePath, template), 'utf8', function (err, data) {
      if (err) { 
          console.log(err); 
          return false; 
      }
      const ejsString = data;
      const template = ejs.compile(ejsString);
      const html = template(information);
      fs.writeFile(path.join(basePath, destFolder, name), html, function(err) {
          if(err) { 
            console.log(err); 
            return false; 
          }

          return true;
      });  
  });
};

// For unique id generator
router.post('/api/uniqueId', async function (req, res) {
  const uuid = generateUUID();
  res.send(uuid);
});

const generateUUID() => {
    
};

// End