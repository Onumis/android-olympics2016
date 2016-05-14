class Api::MoladitiesController < Api::BaseController

  def index
    render json: Moladity.all, status: 200
  end

  def show
    render json: Moladity.find(params[:id]), status: 200
  end

end
