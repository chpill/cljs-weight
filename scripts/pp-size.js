// Inspired from
// http://stackoverflow.com/questions/15900485/correct-way-to-convert-size-in-bytes-to-kb-mb-gb-in-javascript

function beautifyBytes(bytes) {
  if(bytes == 0) return '0 Bytes';
  var k = 1024,
      sizes = ['Bytes', 'K', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
      i = Math.floor(Math.log(bytes) / Math.log(k));
  return parseFloat((bytes / Math.pow(k, i)).toFixed(0)) + '' + sizes[i];
}

// writes to stdout with a line break at the end
console.log(beautifyBytes(process.argv[2]));
