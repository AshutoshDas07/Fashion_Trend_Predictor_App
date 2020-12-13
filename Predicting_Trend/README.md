# Predicting Trends
This part is an effort to predict fashion trends over time using machine learning. Currently, We are able to classify different types of clothing (Shirts, Skirts, Pants, Dress) using images webscraped from chictopia.com, instagram and training a model built using Keras.

## How is this Predicting Trend part set up ?
Currently, this project is split into several files to make prototyping easier. Current workflow:

`webscraper.py --> csvDownload.py --> preprocessing.py --> Trend_Prediction.ipynb`

* `webscraper.py` webscrapes chictopia.com for images and tags.
* `csvDownload.py` actually downloads the scraped images which are fed into.
* `preprocessing.py` to perform image preprocessing.
* Finally, `Trend_Prediction.ipynb` is run to actually train the model and test the model.

## Preprocessing the Web-Srcaped Images
We used [BeautifulSoup](https://pypi.org/project/beautifulsoup4/) to parse webpages. Then, We downloaded the images and start preprocessing.

Let's say we load the following image in `preprocessing.py` :

![airy-deals-dress_4002018-05-24](https://user-images.githubusercontent.com/42767796/102005040-d3295c00-3d3b-11eb-81c2-1a86df6e792a.jpg)

Then we get the following preprocessed image :

![airy-deals-dress_4002018-05-24](https://user-images.githubusercontent.com/42767796/102005080-0e2b8f80-3d3c-11eb-81e5-343fabb751a4.jpg)

We removed the background (everything but humans) using [DeepLabv3+](https://github.com/bonlime/keras-deeplab-v3-plus).

## Training
`Trend_Prediction.ipynb` first creates a pandas dataset using the CSVs from `webscraping.py` and then constructs a 3D numpy array of the arrays created from `preprocessing.py`. After this, training occurs.

Our current model is a 'Convolutional Neural Network Model' having last layer as a softmax layer. Optimizer is Adam.

Result after training:

![Screenshot (93)](https://user-images.githubusercontent.com/42767796/102005284-a9713480-3d3d-11eb-99d4-d44c93bf6f7b.png)

These results are pretty good considering a small and potentially noisy dataset (~1200 images). For further improvements, We might use a GAN (Generational-Adversarial Network) which has been proven to do better for fashion classification and add more images to the dataset.
