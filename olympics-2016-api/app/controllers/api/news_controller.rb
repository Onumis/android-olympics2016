class Api::NewsController < Api::BaseController

  def index
    render json: News.all, status: 200
  end

end
